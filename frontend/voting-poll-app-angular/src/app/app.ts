import { Component } from '@angular/core';
import { PollUiComponent } from "./components/poll-ui-component/poll-ui-component";

@Component({
  selector: 'app-root',
  standalone:true,
  imports: [PollUiComponent],
  templateUrl: './app.html',
  styleUrl: './app.css'
})
export class App {
  protected title = 'voting-poll-app-angular';
}
