import { Component, Input, Output, EventEmitter, AfterContentInit, ContentChildren, QueryList } from '@angular/core';
import { GenericComponent } from '../../component/generic-component';

@Component({
  selector: 'gt-navigation-item',
  templateUrl: './navigation-item.component.html',
  styleUrls: ['./navigation-item.component.scss']
})
export class NavigationItemComponent extends GenericComponent implements AfterContentInit {

  private static DEFAULT_CLASSES = 'navigation-item d-block';

  private static ACTIVE_CLAZZ_KEY = 'Navigation.NavigationItem.Active';
  private static ACTIVE_CLAZZ = 'active';

  @Input() title: string;

  @Input() link: string;

  @Input() external = false;

  @Input() icon: string;

  @Input() expanded = false;

  @Output() activeEvent = new EventEmitter<NavigationItemComponent>();

  @ContentChildren(NavigationItemComponent, { descendants: true }) children: QueryList<NavigationItemComponent>;

  public parent: NavigationItemComponent;

  private $active = false;
  @Input() set active(value: boolean) {
    if (value) {
      this.mapOfClasses.set(NavigationItemComponent.ACTIVE_CLAZZ_KEY, NavigationItemComponent.ACTIVE_CLAZZ);
    } else {
      this.mapOfClasses.delete(NavigationItemComponent.ACTIVE_CLAZZ_KEY);
    }
    this.$active = value;
    this.setUpClasses();

  }
  get active(): boolean {
    return this.$active;
  }

  constructor() {
    super();
  }

  public toggleSubnavigation() {
    if (this.expanded) {
      this.expanded = false;
    } else {
      this.expanded = true;
    }
  }

  public hasChildren() {
    //angular have a bug and bring himself as child
    return this.children.length > 1;
  }

  public activateNavigationItem() {

    this.active = true;
    this.activeEvent.emit(this);

  }

  getClasses(): string {
    return NavigationItemComponent.DEFAULT_CLASSES;
  }

  ngAfterContentInit(): void {
    this.children.map((navigationItem: NavigationItemComponent) => {
      if (this.title !== navigationItem.title && navigationItem.parent == null) {
        navigationItem.parent = this;
      }
    });
  }

}
