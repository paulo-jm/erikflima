import { Component, Input, QueryList, ContentChildren, AfterContentInit } from '@angular/core';
import { GenericComponent } from '../../component/generic-component';
import { NavigationItemComponent } from '../navigation-item/navigation-item.component';

@Component({
  selector: 'sr-navigation',
  templateUrl: './navigation.component.html',
  styleUrls: ['./navigation.component.scss']
})
export class NavigationComponent extends GenericComponent implements AfterContentInit {

  private static DEFAULT_CLASSES = 'navigation d-block shadow-sm';

  @ContentChildren(NavigationItemComponent, { descendants: true }) children: QueryList<NavigationItemComponent>;

  constructor() {
    super();
  }

  getClasses(): string {
    return NavigationComponent.DEFAULT_CLASSES;
  }

  deactivateAllNavigationItems() {
    this.children.forEach(item => {
      item.active = false;
    });
  }

  activateAllParentsNavigationItems(selectedNavigationItem: NavigationItemComponent) {

    selectedNavigationItem.active = true;
    if (selectedNavigationItem.parent != null) {
      this.activateAllParentsNavigationItems(selectedNavigationItem.parent);
    }

  }

  updateActiveStateItems(navigationItem: NavigationItemComponent): void {
    this.deactivateAllNavigationItems();
    this.activateAllParentsNavigationItems(navigationItem);
  }

  ngAfterContentInit(): void {
    this.children.map((navigationItem: NavigationItemComponent) => {
      navigationItem.activeEvent.subscribe(event => {
        this.updateActiveStateItems(event);
      });
    });
  }

}
