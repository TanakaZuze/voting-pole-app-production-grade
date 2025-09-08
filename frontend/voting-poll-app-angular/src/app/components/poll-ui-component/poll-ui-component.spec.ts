import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PollUiComponent } from './poll-ui-component';

describe('PollUiComponent', () => {
  let component: PollUiComponent;
  let fixture: ComponentFixture<PollUiComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [PollUiComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PollUiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
