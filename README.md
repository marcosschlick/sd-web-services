# Events on map

## Build e Execução

### Usando Docker:
```bash
docker build -t events .
docker run -p 8080:8080 events
```

### Usando Podman:
```bash
podman build -t events .
podman run -p 8080:8080 events
```

## Acesso
API disponível em: `http://localhost:8080`
