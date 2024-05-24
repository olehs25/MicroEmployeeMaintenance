import {Component, inject, OnInit} from '@angular/core';
import { BreakpointObserver, Breakpoints } from '@angular/cdk/layout';
import { Observable } from 'rxjs';
import { map, shareReplay } from 'rxjs/operators';

@Component({
  selector: 'app-tenisbar',
  templateUrl: './tenisbar.component.html',
  styleUrls: ['./tenisbar.component.scss']
})
export class TenisbarComponent implements OnInit{
  private breakpointObserver = inject(BreakpointObserver);

  ngOnInit(): void {}

  isHandset$: Observable<boolean> = this.breakpointObserver.observe(Breakpoints.Handset)
    .pipe(
      map(result => result.matches),
      shareReplay()
    );
}
