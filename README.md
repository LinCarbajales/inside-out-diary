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

#### Clonar el repositorio:

Abre tu terminal y clona el proyecto en tu máquina local.

En una terminal Bash:

git clone https://github.com/LinCarbajales/inside-out-diary.git
cd nombre-del-repositorio

#### Compilar el proyecto:

Con Maven, puedes compilar el proyecto con el siguiente comando en Bash:

mvn clean install
Esto creará un archivo .jar ejecutable en el directorio target/.


## mvn test
A continuación, se muestra una captura de la cobertura de código obtenida por los tests:


## Diseño

<img width="3840" height="2635" alt="Untitled diagram _ Mermaid Chart-2025-08-14-121519" src="https://github.com/user-attachments/assets/56a5898d-b64a-44a7-b267-10842faeff90" />


### 🏗️ Patrones de Diseño Implementados
#### MVC (Model-View-Controller)

Controllers: HomeController, MomentController - Lógica de negocio
Views: Interfaz de usuario con herencia desde clase abstracta View
Models: Moment, EmotionEnum - Entidades del dominio

#### Repository Pattern

Interface: InterfaceDB - Contrato de acceso a datos
Implementation: DiaryDatabase - Almacenamiento en memoria
Repository: MomentRepository - Capa de abstracción

#### Singleton Pattern

MomentControllerSingleton - Instancia única del controlador
MomentRepositorySingleton - Instancia única del repositorio

#### DTO Pattern

MomentDTO - Transferencia de datos de entrada
MomentViewDTO - Datos para visualización
MomentFilterDTO - Datos para filtrado

#### Mapper Pattern

MomentMapper - Conversión entre entidades y DTOs

### 🔄 Flujo de Ejecución

Inicialización: App → HomeController → HomeView
Interacción: Usuario selecciona opción → Vista específica
Procesamiento: Vista → MomentControllerSingleton → MomentController
Persistencia: Controller → MomentRepository → DiaryDatabase
Conversión: MomentMapper maneja transformaciones entre DTOs y entidades

### ✨ Características Destacadas

#### Enums Inteligentes

EmotionEnum: 10 emociones predefinidas con métodos de conversión
HomeOptionEnum: Menú con funciones lambda integradas
FilterOptionEnum: Opciones de filtrado tipado

#### Herencia Estructurada

Todas las vistas heredan de View (clase abstracta)
Scanner compartido para entrada de usuario
Reutilización de código común

#### Separación de Responsabilidades

Controladores: Solo lógica de negocio
Vistas: Solo presentación e interacción
Repositorios: Solo acceso a datos
Mappers: Solo conversión de datos
