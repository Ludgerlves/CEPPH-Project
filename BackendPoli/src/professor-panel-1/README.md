# Professor Panel

## Overview
The Professor Panel is a Spring Boot application designed to facilitate the management of academic activities for professors. It provides functionalities for launching notes and attendance, creating activities, uploading materials, visualizing a calendar, and sending messages.

## Features
- **Lançamento de notas/presenças**: Manage and record student grades and attendance.
- **Criação de atividades**: Create and manage academic activities.
- **Upload de materiais**: Upload and manage educational materials.
- **Visualização de calendário**: View important academic dates and events.
- **Envio de mensagens**: Send messages to students or other professors.

## Endpoints
The application exposes the following RESTful endpoints:

- **POST /api/professor/notas**: Submit student grades.
- **POST /api/professor/presencas**: Record student attendance.
- **POST /api/professor/atividades**: Create new academic activities.
- **POST /api/professor/materiais/upload**: Upload educational materials.
- **GET /api/professor/calendario**: Retrieve the academic calendar.
- **POST /api/professor/mensagens**: Send messages to students or staff.

## Setup Instructions
1. **Clone the repository**:
   ```
   git clone <repository-url>
   cd professor-panel
   ```

2. **Build the project**:
   ```
   mvn clean install
   ```

3. **Run the application**:
   ```
   mvn spring-boot:run
   ```

4. **Access the application**: Open your browser and navigate to `http://localhost:8080`.

## Configuration
The application configuration can be found in `src/main/resources/application.properties`. You can set up your database connection and other properties there.

## Testing
To run the tests, use the following command:
```
mvn test
```

## Contribution
Feel free to submit issues or pull requests to improve the application. 

## License
This project is licensed under the MIT License. See the LICENSE file for details.