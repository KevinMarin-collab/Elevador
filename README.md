<div>
  <img style="100%" src="https://capsule-render.vercel.app/api?type=waving&height=100&section=header&reversal=false&fontSize=70&fontColor=FFFFFF&fontAlign=50&fontAlignY=50&stroke=-&descSize=20&descAlign=50&descAlignY=50&theme=cobalt"  />
</div>

###

<h1 align="left">Hola 👋 Te presento mi proyecto de POO</h1>

###

<h3 align="left">Kevin Santiago Marin A.</h3>

<h4 align="left">Elevador de 4 pisos</h4>

###

<h2 align="left">Solución del Problema</h2>

###

<p align="left">El problema consistía en desarrollar un simulador de elevador en Java usando Programación Orientada a Objetos (POO) para CLI, con funcionalidades básicas como movimiento entre pisos, control de puertas y botones, además de mejoras como restricciones de movimiento (no subir o bajar con puertas abiertas), cierre automático de puertas tras 3 segundos, simulación de viaje con delays de 2 segundos por piso y mensajes de progreso, e integración de botones internos y externos al menú. El análisis reveló que era viable con clases modulares para promover encapsulamiento, herencia y composición, priorizando extensibilidad y manejo de errores. Se pensó en un diseño centralizado en la clase Elevador, que delega a Puerta (con hilo para auto-cierre) y Tablero (para mostrar estado), mientras Boton sirve como base para BotonInterior y BotonExterior con polimorfismo en presionar(). La implementación siguió fases: estructura básica de clases, agregando restricciones y simulación, integrando botones al menú de ElevadorPrincipal con validaciones, y refinando mensajes y opciones. Se usaron Thread.sleep para tiempo real y Scanner para input, resolviendo desafíos como sincronización de hilos y orden de simulación. El resultado es un código modular y funcional, con menú intuitivo que cumple requisitos, demostrando POO efectiva y facilidad para extensiones futuras.</p>

###

<h2 align="left">Diagrama de Clase</h2>

###

<div align="center">
  <img height="400" src="Screenshot from 2025-11-17 10-10-15.png"/>
</div>

###

<h2 align="left">Hecho con:</h2>

###

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/java/java-original.svg" height="40" alt="java logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/github/github-original.svg" height="40" alt="github logo"  />
</div>

###