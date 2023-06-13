import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Resolve, RouterStateSnapshot } from '@angular/router';
import { Observable, of } from 'rxjs';

import { Course } from '../model/course';
import { CoursesService } from '../services/courses.service';
// export const courseResolver: ResolveFn<boolean> = (route, state) => {
//   return true;
// };


@Injectable({
  providedIn: 'root'
})


// export class CourseResolver implements ResolveFn<Course> {

export class courseResolver implements Resolve<Course> {

  constructor(private service: CoursesService) { }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Course> {
    if (route.params && route.params['id']) {
      return this.service.loadById(route.params['id']);
    }
    return of({ _id: '', name: '', category: ''});
  }
}
