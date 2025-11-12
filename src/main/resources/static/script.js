// create event
const nameCreateEvent = document.getElementById("create-event-name");
const descriptionCreateEvent = document.getElementById(
  "create-event-description"
);
const dateCreateEvent = document.getElementById("create-event-date");
const timeCreateEvent = document.getElementById("create-event-time");
const latCreateEvent = document.getElementById("create-event-lat");
const lonCreateEvent = document.getElementById("create-event-lon");
const btnCreateEvent = document.getElementById("create-event-btn");

btnCreateEvent.onclick = async function () {
  const name = nameCreateEvent.value;
  const description = descriptionCreateEvent.value;
  const date = dateCreateEvent.value;
  const time = timeCreateEvent.value;
  const lat = parseFloat(latCreateEvent.value);
  const lon = parseFloat(lonCreateEvent.value);

  if (
    !name ||
    !description ||
    !date ||
    !time ||
    !latCreateEvent.value ||
    !lonCreateEvent.value
  ) {
    alert("Você deve preencher todos os campos");
    return;
  }
  if (isNaN(lat) || isNaN(lon)) {
    alert("Latitude e longitude devem ser números válidos");
    return;
  }
  try {
    const response = await fetch("http://localhost:8080/events", {
      method: "POST",
      body: JSON.stringify({
        name: name,
        description: description,
        date: `${date}T${time}`,
        lat: lat,
        lon: lon,
      }),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    });
    if (response.ok) {
      alert("Evento criado com sucesso");

      nameCreateEvent.value = "";
      descriptionCreateEvent.value = "";
      dateCreateEvent.value = "";
      timeCreateEvent.value = "";
      latCreateEvent.value = "";
      lonCreateEvent.value = "";
    } else {
      const error = await response.text();
      console.error(error);
      alert("Erro ao criar evento: " + error);
    }
  } catch (error) {
    console.error(error);
    // alert("Erro na conexão com o servidor");
  }
};

// update event
const idUpdateEvent = document.getElementById("update-event-id");
const nameUpdateEvent = document.getElementById("update-event-name");
const descriptionUpdateEvent = document.getElementById(
  "update-event-description"
);
const dateUpdateEvent = document.getElementById("update-event-date");
const timeUpdateEvent = document.getElementById("update-event-time");
const latUpdateEvent = document.getElementById("update-event-lat");
const lonUpdateEvent = document.getElementById("update-event-lon");
const btnUpdateEvent = document.getElementById("update-event-btn");

btnUpdateEvent.onclick = async function () {
  const id = parseInt(idUpdateEvent.value);
  const name = nameUpdateEvent.value;
  const description = descriptionUpdateEvent.value;
  const date = dateUpdateEvent.value;
  const time = timeUpdateEvent.value;
  const lat = latUpdateEvent.value ? parseFloat(latUpdateEvent.value) : NaN;
  const lon = lonUpdateEvent.value ? parseFloat(lonUpdateEvent.value) : NaN;

  if (isNaN(id)) {
    alert("ID é obrigatório");
    return;
  }

  const updateData = {};

  if (nameUpdateEvent.value) {
    updateData.name = nameUpdateEvent.value;
  }
  if (descriptionUpdateEvent.value) {
    updateData.description = descriptionUpdateEvent.value;
  }
  if (dateUpdateEvent.value && timeUpdateEvent.value) {
    updateData.date = `${dateUpdateEvent.value}T${timeUpdateEvent.value}`;
  }
  if (!isNaN(lat)) updateData.lat = lat;
  if (!isNaN(lon)) updateData.lon = lon;

  try {
    const response = await fetch(`http://localhost:8080/events/${id}`, {
      method: "PUT",
      body: JSON.stringify(updateData),
      headers: {
        "Content-type": "application/json; charset=UTF-8",
      },
    });
    if (response.ok) {
      alert("Evento atualizado com sucesso");

      idUpdateEvent.value = "";
      nameUpdateEvent.value = "";
      descriptionUpdateEvent.value = "";
      dateUpdateEvent.value = "";
      latUpdateEvent.value = "";
      lonUpdateEvent.value = "";
    } else {
      const error = await response.text();
      console.error(error);
      alert("Erro ao atualizar evento: " + error);
    }
  } catch (error) {
    console.error(error);
    // alert("Erro na conexão com o servidor");
  }
};

// get all events
const btnListAllEvents = document.getElementById("list-all-events-btn");

btnListAllEvents.onclick = async function () {
  try {
    const response = await fetch("http://localhost:8080/events");

    if (response.ok) {
      const eventos = await response.json();
      const container = document.getElementById("events-container");

      container.innerHTML = "";

      eventos.forEach((evento) => {
        const row = document.createElement("tr");

        const dataHora = new Date(evento.date);
        const data = dataHora.toISOString().split("T")[0];
        const hora = dataHora.toTimeString().split(" ")[0].substring(0, 5);

        row.innerHTML = `
          <td id="list-all-events-id-${evento.id}">${evento.id}</td>
          <td id="list-all-events-name-${evento.id}">${evento.name}</td>
          <td id="list-all-events-description-${evento.id}">${evento.description}</td>
          <td id="list-all-events-date-${evento.id}">${data}</td>
          <td id="list-all-events-time-${evento.id}">${hora}</td>
          <td id="list-all-events-lat-${evento.id}">${evento.lat}</td>
          <td id="list-all-events-lon-${evento.id}">${evento.lon}</td>
        `;

        container.appendChild(row);
      });
    } else {
      const error = await response.text();
      console.error(error);
    }
  } catch (error) {
    console.error(error);
  }
};
