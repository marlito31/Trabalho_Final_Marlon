import { MarcaCreateComponent } from './marca-create/component/marca-create.component';
import { CommonModule } from "@angular/common";
import { NgModule } from “@angular/core";
import { FormsModule } from '@angular/forms';
@NgModule({
 imports: [
 CommonModule,
 FormsModule
 ],
 declarations: [
 MarcaCreateComponent
 ],
 exports: [
 MarcaCreateComponent
 ],
})
export class MarcaModule {}