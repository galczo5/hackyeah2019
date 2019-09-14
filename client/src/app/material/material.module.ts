import { NgModule } from '@angular/core';
import { Provider } from '@angular/compiler/src/core';
import { MatCardModule } from '@angular/material/card';
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatGridListModule} from "@angular/material/grid-list";

const modules: Array<Provider> = [
  MatCardModule,
  MatToolbarModule,
  MatGridListModule
];

@NgModule({
  imports: modules,
  exports: modules
})
export class MaterialModule { }
