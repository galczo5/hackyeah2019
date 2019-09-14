export class Location {
  constructor(private readonly lon: number,
              private readonly lat: number) {
  }

  getLongitude(): number {
    return this.lon;
  }

  getLatitude(): number {
    return this.lat;
  }

}
