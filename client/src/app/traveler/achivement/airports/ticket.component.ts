import { Component, Input } from '@angular/core';
import { Achievement } from '../achivement';

@Component({
  selector: 'app-ticket',
  template: `
	  <span class="ticket-wrapper">
          <span class="ticket-bg ticket-left">{{ airport.image }}</span>
          <span class="ticket-bg ticket-right"></span>
      </span>`,
  styles: [`

	  .ticket-wrapper {
		  display: inline-flex;
		  align-items: center;
		  justify-content: center;
		  font-weight: 400;
		  margin-bottom: 10px;
	  }

	  .ticket-bg {
		  background: #E2E3F9;
		  padding: 4px 8px;
		  display: inline-flex;
		  align-items: center;
		  justify-content: center;
		  height: 20px;
	  }

	  .ticket-left {
		  border-bottom: 4px solid #5A4ED0;
		  border-bottom-left-radius: 4px;
		  border-right: 3px dotted #CD4470;
	  }

	  .ticket-right {
		  border-bottom: 4px solid #5A4ED0;
		  border-bottom-right-radius: 4px;
		  padding-right: 4px;
	  }
  `]
})
export class TicketComponent {

  @Input()
  airport: Achievement;

}
