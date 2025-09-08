import { HttpClient } from '@angular/common/http';
import { ChangeDetectorRef, Injectable } from '@angular/core';
import { Poll } from '../models/poll';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class PollService {
  private backendBaseUrl: string = "http://localhost:8080";

  constructor(private httpClient: HttpClient) { }
  // methods to consume spring backend APIS namely i) create poll,findPollById,getAllPolls and vote for poll option

  public createPoll(poll: Poll): Observable<Poll> {
    return this.httpClient.post<Poll>(`${this.backendBaseUrl}/create-poll`, poll);
  }

  public getAllPolls(): Observable<Poll[]> {
    return this.httpClient.get<Poll[]>(`${this.backendBaseUrl}/get-all-polls`);
  }

  public getPollById(pollId: number): Observable<Poll> {
    return this.httpClient.get<Poll>(`${this.backendBaseUrl}/get-poll-by-id/${pollId}`);
  }

  // vote for poll option
  public voteForPollOption(pollId: number, pollOptionIndex: number): Observable<void> {
    return this.httpClient.post<void>(`${this.backendBaseUrl}/vote`, { pollId, pollOptionIndex });
  }

  // delete poll
  public deletePollById(pollId: number): Observable<void> {
        return this.httpClient.delete<void>(`${this.backendBaseUrl}/deleteById/${pollId}`)
  }

}
