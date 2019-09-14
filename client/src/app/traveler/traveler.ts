import { UserInfo } from '../shared/profile/user-info';

export class Traveler implements UserInfo {

  constructor(public name: string,
              public avatar: string,
              public nationality: string,
              public languages: Array<string>) {}

}
