import { Component, inject } from '@angular/core';
import { Breakpoints, BreakpointObserver } from '@angular/cdk/layout';
import { map } from 'rxjs/operators';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent {
  private breakpointObserver = inject(BreakpointObserver);

  /** Based on the screen size, switch from standard to one column per row */
  cards = this.breakpointObserver.observe(Breakpoints.Handset).pipe(
    map(({ matches }) => {
      if (matches) {
        return [
          { title: 'TENIS | EDUCACIÓN | DISCIPLINA | PERSEVERANCIA 🎾\n' +
              '📍 Polideportivo Jose Juan Rodríguez\n' +
              '📧 tenisoluladelrio@gmail.com', cols: 1, rows: 1 },
          { title: 'Escuela de Tenis', cols: 1, rows: 1 , body: '¡Comienza una nueva era del Tenis Olula del Rio!\n' +
              'Practica con nosotros este maravilloso deporte de una forma divertida, motivadora y profesional a la vez ' +
              'que sana y beneficiosa para la salud. Clases para todas las edades y niveles.'},
          { title: 'Reserva de pistas', cols: 1, rows: 1 , body: '¡Comienza una nueva era del Tenis Olula del Rio!\n' +
              'Practica con nosotros este maravilloso deporte de una forma divertida, motivadora y profesional a la vez que ' +
              'sana y beneficiosa para la salud. Clases para todas las edades y niveles.\n' +
              '\n'},
          { title: 'Instalaciones', cols: 1, rows: 1, body: '¡Comienza una nueva era del Tenis Olula del Rio!\n' +
              'Practica con nosotros este maravilloso deporte de una forma divertida, motivadora y profesional a la vez que sana ' +
              'y beneficiosa para la salud. Clases para todas las edades y niveles.' },
          { title: 'Instalaciones', cols: 1, rows: 1, body: '¡Comienza una nueva era del Tenis Olula del Rio!\n' +
              'Practica con nosotros este maravilloso deporte de una forma divertida, motivadora y profesional a la vez que sana ' +
              'y beneficiosa para la salud. Clases para todas las edades y niveles.' }

        ];
      }

      return [
        { title:'Por qué elegir Club de Tenis Olula del Rio', body: 'Las instalaciones del club se encuentran en un entorno único de 50.000 m2 rodeado de \n' +
            'grandes arboles, piscina, catorce pistas de tenis, campo de Fútbol 7, cinco pistas de pádel, canastas \n' +
            'y nuevo gimnasio. Esto es atractivo para cualquier deportista, pero es mucho más que eso. Nuestro \n' +
            'restaurante en el entorno de la piscina permite conciliar la vida social con el deporte. Fiestas temáticas,\n' +
            ' navideñas, etc. A esto debes sumar la tranquilidad de los padres cuando no hay colegio con el comodín del \n' +
            'club. Tus hijos disfrutarán al aire libre en la escuela de verano, escuela de navidad y días deportivos.',
          cols: 2, rows: 1 },
        { title: 'Escuela de Tenis', cols: 1, rows: 1 , body: '¡Comienza una nueva era del Tenis Olula del Rio!\n' +
            'Practica con nosotros este maravilloso deporte de una forma divertida, motivadora y profesional a la vez ' +
            'que sana y beneficiosa para la salud. Clases para todas las edades y niveles.'},
        { title: 'Reserva de pistas', cols: 1, rows: 1 , body: '¡Comienza una nueva era del Tenis Olula del Rio!\n' +
            'Practica con nosotros este maravilloso deporte de una forma divertida, motivadora y profesional a la vez que ' +
            'sana y beneficiosa para la salud. Clases para todas las edades y niveles.\n' +
            '\n'},
        { title: 'Instalaciones', cols: 1, rows: 1, body: '¡Comienza una nueva era del Tenis Olula del Rio!\n' +
            'Practica con nosotros este maravilloso deporte de una forma divertida, motivadora y profesional a la vez que sana ' +
            'y beneficiosa para la salud. Clases para todas las edades y niveles.' },
        { title: 'Instalaciones', cols: 1, rows: 1, body: '¡Comienza una nueva era del Tenis Olula del Rio!\n' +
            'Practica con nosotros este maravilloso deporte de una forma divertida, motivadora y profesional a la vez que sana ' +
            'y beneficiosa para la salud. Clases para todas las edades y niveles.' }
      ];
    })

  );
  imageObject = [{
    image: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/5.jpg',
    thumbImage: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/5.jpg',
    title: 'Hummingbirds are amazing creatures'
  }, {
    image: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/9.jpg',
    thumbImage: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/9.jpg'
  }, {
    image: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/4.jpg',
    thumbImage: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/4.jpg',
    title: 'Example with title.'
  },{
    image: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/7.jpg',
    thumbImage: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/7.jpg',
    title: 'Hummingbirds are amazing creatures'
  }, {
    image: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/1.jpg',
    thumbImage: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/1.jpg'
  }, {
    image: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/2.jpg',
    thumbImage: 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/2.jpg',
    title: 'Example two with title.'
  }];
}
