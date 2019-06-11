import { Injectable } from '@angular/core';
import { Endopoint } from './model/endopoint';

@Injectable({
  providedIn: 'root'
})
export class EndpointFactoryService {

  mapOfEndpoints: Map<string, Endopoint> = new Map();

  addEndpoint(identifier: string, endopoint: Endopoint): void {
    this.mapOfEndpoints.set(identifier, endopoint);
  }

  getEndpoint(identifier: string) {

    if (this.mapOfEndpoints && this.mapOfEndpoints.has(identifier)) {
      return this.mapOfEndpoints.get(identifier);
    }

    return null;

  }

}
