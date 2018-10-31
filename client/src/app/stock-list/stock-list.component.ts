import { Component, OnInit } from '@angular/core';
import { StockService } from '../shared';

@Component({
  selector: 'app-stock-list',
  templateUrl: './stock-list.component.html',
  styleUrls: ['./stock-list.component.css'],
  providers: [StockService]
})
export class StockListComponent implements OnInit {
  stocks: Array<any>;

  constructor(private stockService: StockService) { }

  ngOnInit() {
    this.stockService.getAll().subscribe(
      data => {
        this.stocks = data;
      },
      error => console.log(error)
    )
  }
}
