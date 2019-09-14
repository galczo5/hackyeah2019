import { ReplaySubject, Observable } from "rxjs";

export abstract class Store<T> {

  private value$: ReplaySubject<T> = new ReplaySubject<T>(1);

  protected constructor(defaultValue?: T) {
    if (defaultValue !== undefined) {
      this.set(defaultValue);
    }
  }

  set(newValue: T): void {
    this.value$.next(newValue);
  }

  select(): Observable<T> {
    return this.value$.asObservable();
  }

}
