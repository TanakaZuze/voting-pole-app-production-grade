import { ChangeDetectorRef, Component, OnInit } from '@angular/core';
import { Poll } from '../../models/poll';
import { PollService } from '../../services/poll-service';
import { HttpErrorResponse } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';


@Component({
  selector: 'app-poll-ui-component',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './poll-ui-component.html',
  styleUrl: './poll-ui-component.css'
})
export class PollUiComponent implements OnInit {
  // variable to receive the List coming from spring hence array
  public polls: Poll[] = [];
  // variable to hold values for the new poll
  public newPoll: Poll = {
    question: '',
    options: [
      { voteCount: 0, voteOption: '' },
      { voteCount: 0, voteOption: '' }
    ]
  };

  constructor(private pollService: PollService, private cd: ChangeDetectorRef) { }

  ngOnInit() {
    this.getAllPolls();
    this.cd.detectChanges();
  }

  public getAllPolls(): void {
    this.pollService.getAllPolls().subscribe({
      next: (data: Poll[]) => {
        this.polls = data;
        this.cd.detectChanges(); // force Angular to update UI immediately
      },
      error: (error: HttpErrorResponse) => alert(error.message)
    });
  }

  public createNewPoll() {
    this.pollService.createPoll(this.newPoll).subscribe(
      {
        next: (createdPoll) => {
          this.polls.push(createdPoll);
          this.formReset();
          this.cd.detectChanges()
        },
        error: (error) => {
          console.log(error);
        }
      }
    )
  }

  public voteForPollOption(pollId: number, pollOptionIndex: number): void {
    this.pollService.voteForPollOption(pollId, pollOptionIndex+1).subscribe({
      next: () => {
        const poll = this.polls.find(p => p.id === pollId);
        if (poll) {
          poll.options[pollOptionIndex].voteCount++;
          this.cd.detectChanges();
        }
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message)
      }
    })
  }

  public addOption(): void {
    this.newPoll.options.push({ voteCount: 0, voteOption: '' })

  }

  public deletePoll(pollId: number): void {
    this.pollService.deletePollById(pollId).subscribe({
      next: () => {
        // remove the deleted poll from local state
        this.polls = this.polls.filter(p => p.id !== pollId);
        this.cd.detectChanges();
      },
      error: (error: HttpErrorResponse) => {
        alert(error.message);
      }
    });
  }


  public trackByIndex(index: number): number {
    return index;
  }

  // form Reset
  public formReset(): void {
    this.newPoll = {
      question: '',
      options: [
        { voteCount: 0, voteOption: '' },
        { voteCount: 0, voteOption: '' }
      ]
    };
    this.cd.detectChanges()
  }

}