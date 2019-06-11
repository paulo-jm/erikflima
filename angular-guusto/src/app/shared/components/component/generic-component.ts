import { OnInit, Input, HostBinding } from '@angular/core';

export abstract class GenericComponent implements OnInit {

  public static DASH = '-';
  public static SPACE = ' ';
  public static BACKGROUND_KEY = 'GenericComponent.Background';

  protected mapOfClasses: Map<string, string> = new Map();

  @Input() set background(value: string) {
    this.mapOfClasses.set(GenericComponent.BACKGROUND_KEY, value);
    this.setUpClasses();
  }
  get background(): string {
    return this.mapOfClasses.get(GenericComponent.BACKGROUND_KEY);
  }

  @HostBinding('class') clazz: string;

  setUpClasses() {

    let classesToAdd = '';
    if (this.mapOfClasses.size > 0) {
      classesToAdd = Array.from(this.mapOfClasses.values()).join(GenericComponent.SPACE);
    }

    const defaultClasses = this.getClasses();

    if (defaultClasses) {
      this.clazz = defaultClasses.concat(GenericComponent.SPACE, classesToAdd.trim());
    } else {
      this.clazz = GenericComponent.SPACE, classesToAdd.trim();
    }

  }


  addClazz(clazz: string) {
    this.mapOfClasses.set(clazz, clazz);
    this.setUpClasses();
  }

  removeClazz(clazz: string) {
    if (this.mapOfClasses.has(clazz)) {
      this.mapOfClasses.delete(clazz);
      this.setUpClasses();
    }
  }

  abstract getClasses(): string;

  ngOnInit() {
    this.setUpClasses();
  }

}
