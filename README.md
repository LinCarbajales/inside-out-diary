# Inside Out Diary

## Descripción del Proyecto
Este proyecto es una aplicación de consola para la gestión de un diario de momentos personales. Permite a los usuarios registrar, visualizar y eliminar sus recuerdos, cada uno asociado a una emoción y una fecha específica.

La aplicación busca ser una herramienta sencilla para que los usuarios puedan llevar un registro de sus vivencias y consultarlas fácilmente, ya sea de forma general o filtrando por la emoción o la fecha en que ocurrieron.

Cada momento del diario se compone de la siguiente información:

#### Identificador

#### Título

#### Descripción

#### Emoción (una de las 10 predefinidas)

#### Fecha del momento

#### Fecha de creación

#### Fecha de modificación

## Funcionalidades
Las principales funcionalidades de la aplicación son:

#### Añadir un momento: Registrar un nuevo recuerdo con todos sus detalles.

#### Ver momentos: Recuperar y visualizar la lista completa de momentos guardados.

#### Eliminar un momento: Borrar una entrada del diario para mantenerlo organizado.

#### Filtrar momentos: Buscar momentos específicos por emoción o por mes.

#### Salir del programa: Finalizar la ejecución de la aplicación de forma segura.

## Pre-requisitos

Para ejecutar este proyecto, necesitas tener instalado lo siguiente:

Java Development Kit (JDK).

Maven.

### Pasos para la instalación
Clonar el repositorio:
Abre tu terminal y clona el proyecto en tu máquina local.

Bash

git clone https://github.com/LinCarbajales/inside-out-diary.git
cd nombre-del-repositorio
Compilar el proyecto:
Si usas Maven, puedes compilar el proyecto con el siguiente comando:

Bash

mvn clean install
Esto creará un archivo .jar ejecutable en el directorio target/.

Ejecución de los tests
El proyecto incluye tests unitarios para asegurar el correcto funcionamiento de las funcionalidades clave. Puedes ejecutar los tests con el siguiente comando de Maven:

Bash

## mvn test
A continuación, se muestra una captura de la cobertura de código obtenida por los tests:
