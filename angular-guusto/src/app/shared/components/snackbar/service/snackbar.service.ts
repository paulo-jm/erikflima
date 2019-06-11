import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class SnackbarService {

  constructor() { }

  public open(message: string, action: string = null) {
    alert(message);
  }

}
