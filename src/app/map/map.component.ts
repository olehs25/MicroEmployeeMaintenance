import { Component } from '@angular/core';
import {circle, Map, marker, tileLayer} from "leaflet";

@Component({
  selector: 'app-map',
  templateUrl: './map.component.html',
  styleUrls: ['./map.component.scss']
})
export class MapComponent {

ngAfterViewInit(){
  const map = new Map('map').setView([37.35015,-2.29615], 16);

  tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
    maxZoom: 19,
    attribution: '&copy; <a href="https://www.openstreetmap.org/copyright">OpenStreetMap</a> contributors'
  }).addTo(map);

  //marker([37.35010,-2.29612]).addTo(map).bindPopup("Pistas de Tenis Olula del Rio");
  circle([37.35010,-2.29612], {
    color: 'red',
    fillColor: '#f03',
    fillOpacity: 0.5,
    radius: 30
  }).addTo(map).bindPopup("Pistas de Tenis Olula del Rio");


  //map.fitBounds([[markerItem.getLatLng().lat, markerItem.getLatLng().lng]]);

  }


}
