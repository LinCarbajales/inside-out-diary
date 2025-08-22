# Inside Out Diary

## En desarrollo

Tras finalizar la versión 1.0, el proyecto se encuentra actualmente en desarrollo con nuevas funcionalidades en proceso de implementación. Primero he incluido la posibilidad de guardar los momentos en un archivo csv (pendiente de refactorización para incluir dto). Después he añadido una opción de guardar película, que a través de la arquitectura mvc recoge los datos de una película desde una api. Los datos son tratados con value_objects y dtos para convertir aquellos que interesan: el título de la película, el año de su estreno y el género o géneros a los que pertenece. De momento, estos datos solo se imprimen en pantalla, pero el objetivo es que se guarden en un archivo csv.

#### A continuación se muestra el readme original con las especificaciones iniciales del proyecto. Esta versión completamente funcional y con testing implementado se puede revisar en la rama v1.0.

## 📖 README del Proyecto original completado (rama v1.0)

Este proyecto es una aplicación de consola para la gestión de un diario de momentos personales. Permite a los usuarios registrar, visualizar y eliminar sus recuerdos, cada uno asociado a una emoción y una fecha específica.

La aplicación busca ser una herramienta sencilla para que los usuarios puedan llevar un registro de sus vivencias y consultarlas fácilmente, ya sea de forma general o filtrando por la emoción o la fecha en que ocurrieron.

### 📝 Estructura de un Momento

Cada momento del diario se compone de la siguiente información:

- **Identificador**
- **Título** 
- **Descripción**
- **Emoción** (una de las 10 predefinidas)
- **Fecha del momento**
- **Fecha de creación**
- **Fecha de modificación**

### ⚡ Funcionalidades

Las principales funcionalidades de la aplicación son:

- **➕ Añadir un momento**: Registrar un nuevo recuerdo con todos sus detalles
- **👀 Ver momentos**: Recuperar y visualizar la lista completa de momentos guardados
- **🗑️ Eliminar un momento**: Borrar una entrada del diario para mantenerlo organizado
- **🔍 Filtrar momentos**: Buscar momentos específicos por emoción o por fecha
- **🚪 Salir del programa**: Finalizar la ejecución de la aplicación

## 🚀 Instalación

### Prerrequisitos
- Java 17 o superior
- Maven 3.6+ (opcional, si usas Maven)
- Git

### Pasos para la instalación

#### 1. Clonar el repositorio
Abre tu terminal bash y clona el proyecto en tu máquina local:

git clone https://github.com/LinCarbajales/inside-out-diary.git
cd inside-out-diary

#### 2. Compilar el proyecto

##### Con Maven:
mvn clean compile

##### Con Java directamente:
javac -d bin -cp src src/dev/lin/**/*.java

#### Para generar JAR ejecutable (Maven):
mvn clean package

#### 3. Ejecutar el proyecto

##### Con Maven:
mvn exec:java -Dexec.mainClass="dev.lin.App"

##### Con Java directamente:
java -cp bin dev.lin.App

#### Con JAR ejecutable:
java -jar target/inside-out-diary-1.0.jar

### Ejecución
Una vez compilado, la aplicación se ejecutará en la consola y mostrará el menú principal del diario emocional.

## Testing

Para el testing se ha utilizado JUnit 5.12, System Rules de Stefan Birkner en las views y Mockito en los controllers.

A continuación, se muestra una captura de la cobertura de código obtenida por los tests:

<img width="218" height="328" alt="image" src="https://github.com/user-attachments/assets/223720ea-f8df-4b91-b7cf-327f93ac8fc8" />


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




