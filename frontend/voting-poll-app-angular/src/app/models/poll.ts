import { PollOption } from "./poll-option";

export interface Poll {
    id?: number | any;
    question: string;
    options: PollOption[];
}
