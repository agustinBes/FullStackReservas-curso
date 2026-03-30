# Formulario Reactivo para Crear Reservas

## Descripción
Se ha creado un formulario reactivo completo en Angular para la creación de nuevas reservas con validación, manejo de errores y notificaciones.

## Componentes Creados

### 1. **CrearReservaComponent** (`crear-reserva.component.ts`)
Componente principal del formulario con:
- Formulario reactivo con validaciones
- Campos: nombre del cliente, fecha, hora, servicio
- Todos los campos son obligatorios
- Manejo de errores con mensajes personalizados
- Integración con `ReservaService` para crear reservas
- Redirección automática a la lista de reservas tras crear una reserva

### 2. **ToastService** (`toast.service.ts`)
Servicio para mostrar notificaciones:
- Métodos: `success()`, `error()`, `warning()`, `info()`
- Desaparición automática después de un tiempo configurable
- ID único para cada notificación

### 3. **ToastComponent** (`toast.component.ts`)
Componente que muestra las notificaciones:
- Ubicado en la esquina superior derecha
- Responsive y animado
- Cierre manual o automático

## Servicios Disponibles

El componente incluye 7 servicios recomendados:
- 🏨 Alojamiento
- 🍽️ Comidas
- 🎭 Entretenimiento
- 🚌 Tours y Excursiones
- 🧹 Limpieza
- 🚗 Transporte
- 📋 Asesoramiento

## Rutas

Se han agregado las siguientes rutas:
- `/reservas` - Lista de reservas
- `/nueva-reserva` - Formulario para crear nueva reserva

## Características

✅ **Validaciones:**
- Campo nombre: requerido, mínimo 3 caracteres
- Campo fecha: requerido
- Campo hora: requerido
- Campo servicio: requerido (selección de lista)

✅ **Manejo de Errores:**
- Mensajes de error personalizados por campo
- Toast de error si ocurre un problema al guardar
- Validación en tiempo real

✅ **UX Mejorada:**
- Indicadores visuales de campos requeridos
- Botón de envío deshabilitado mientras se procesa
- Botón "Limpiar" para resetear el formulario
- Botón "Cancelar" para volver a la lista
- Transición automática a la lista tras crear una reserva

## Integración

El componente ya está:
- Registrado en las rutas (`app.routes.ts`)
- Importado en el componente principal (`app.ts`)
- Integrado con el componente de lista de reservas (botón "+ Nueva Reserva")

## Cómo Usar

1. Navega a `/nueva-reserva` o haz clic en el botón "+ Nueva Reserva" desde la lista
2. Completa los campos del formulario
3. Haz clic en "Crear Reserva"
4. Si hay éxito, verás un toast verde y serás redirigido a la lista
5. Si hay error, verás un toast rojo con el mensaje de error

## Estilos

El formulario es completamente responsivo:
- Diseño adaptable a móviles, tablets y escritorio
- Tema de color morado/gradiente
- Animaciones suaves
- Accesibilidad mejorada

## Integración Backend

El componente ya llama al método `criarReserva()` del `ReservaService`, que realiza una petición POST a:
```
${environment.apiUrl}/reservaciones
```

Asegúrate de que tu backend maneje correctamente las solicitudes POST con los campos:
- `name`: string (nombre del cliente)
- `date`: string (fecha en formato YYYY-MM-DD)
- `time`: string (hora en formato HH:mm)
- `service`: string (nombre del servicio)
- `status`: string (por defecto "ACTIVA")
