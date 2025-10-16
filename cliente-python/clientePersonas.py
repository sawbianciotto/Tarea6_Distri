import sys
import datetime
import configparser
import requests
from requests.structures import CaseInsensitiveDict
import datetime
from datetime import timedelta


#Variables globales para verificacion
archivo_config = 'ConfigFile.properties'
config = None

# Carga las variables de configuración desde el archivo ConfigFile.properties
def cargar_variables():
    global config
    config = configparser.RawConfigParser()
    config.read(archivo_config)

# Lista todos los usuarios llamando al endpoint correspondiente
def listar_usuarios():
    url = config.get('SeccionApi', 'api_usuarios_url_listar')
    response = requests.get(url)
    if response.status_code == 200:
        print("Usuarios:")
        print(response.json())
    else:
        print(f"Error al listar usuarios: {response.status_code}")

# Lista todas las monedas llamando al endpoint correspondiente
def listar_monedas():
    url = config.get('SeccionApi', 'api_monedas_url_listar')
    response = requests.get(url)
    if response.status_code == 200:
        print("Monedas:")
        print(response.json())
    else:
        print(f"Error al listar monedas: {response.status_code}")

# Lista todos los clientes llamando al endpoint correspondiente
def listar_clientes():
    url = config.get('SeccionApi', 'api_clientes_url_listar')
    response = requests.get(url)
    if response.status_code == 200:
        print("Clientes:")
        print(response.json())
    else:
        print(f"Error al listar clientes: {response.status_code}")

# Obtiene el detalle de un usuario específico por su ID
def detalle_usuario(id):
    url = config.get('SeccionApi', 'api_usuarios_url_detalle').format(id=id)
    response = requests.get(url)
    if response.status_code == 200:
        print("Detalle de usuario:")
        print(response.json())
    else:
        print(f"Error al obtener detalle de usuario: {response.status_code}")

# Obtiene el detalle de un cliente específico por su CI
def detalle_cliente(ci_cliente):
    url = config.get('SeccionApi', 'api_clientes_url_detalle').format(ci=ci_cliente)
    response = requests.get(url)
    if response.status_code == 200:
        print("Detalle de cliente:")
        print(response.json())
    else:
        print(f"Error al obtener detalle de cliente: {response.status_code}")

# Obtiene el detalle de una moneda específica por su código ISO
def detalle_moneda(codigo_iso):
    url = config.get('SeccionApi', 'api_monedas_url_detalle').format(codigoISO=codigo_iso)
    response = requests.get(url)
    if response.status_code == 200:
        print("Detalle de moneda:")
        print(response.json())
    else:
        print(f"Error al obtener detalle de moneda: {response.status_code}")

# Crea un nuevo cliente enviando los datos al endpoint correspondiente
def crear_cliente():
    url = config.get('SeccionApi', 'api_clientes_url_crear')
    cliente = {
        "ci": input("Ingrese CI: "),
        "nombre": input("Ingrese nombre: "),
        "apellido": input("Ingrese apellido: ")
    }
    response = requests.post(url, json=cliente)
    if response.status_code == 200 or response.status_code == 201:
        print("Cliente creado exitosamente.")
    else:
        print(f"Error al crear cliente: {response.status_code}")

# Edita un usuario existente por su ID
def editar_usuario():
    id = input("Ingrese ID del usuario a editar: ")
    url = config.get('SeccionApi', 'api_usuarios_url_editar').format(id=id)
    usuario = {
        "nombre": input("Ingrese nuevo nombre: "),
        "apellido": input("Ingrese nuevo apellido: ")
    }
    response = requests.put(url, json=usuario)
    if response.status_code == 200:
        print("Usuario editado exitosamente.")
    else:
        print(f"Error al editar usuario: {response.status_code}")

# Elimina una moneda específica por su código ISO
def eliminar_moneda():
    codigo_iso = input("Ingrese código ISO de la moneda a eliminar: ")
    url = config.get('SeccionApi', 'api_monedas_url_eliminar').format(codigoISO=codigo_iso)
    response = requests.delete(url)
    if response.status_code == 204:
        print("Moneda eliminada exitosamente.")
    else:
        print(f"Error al eliminar moneda: {response.status_code}")

# Crea una nueva moneda enviando los datos al endpoint correspondiente
def crear_moneda():
    url = config.get('SeccionApi', 'api_monedas_url_crear')
    moneda = {
        "codigoISO": input("Ingrese código ISO: "),
        "nombre": input("Ingrese nombre de la moneda: "),
        "simbolo": input("Ingrese símbolo de la moneda: ")
    }
    response = requests.post(url, json=moneda)
    if response.status_code == 200 or response.status_code == 201:
        print("Moneda creada exitosamente.")
    else:
        print(f"Error al crear moneda: {response.status_code}")

# Crea un nuevo usuario enviando los datos al endpoint correspondiente
def crear_usuario():
    url = config.get('SeccionApi', 'api_usuarios_url_crear')
    usuario = {
        "nombre": input("Ingrese nombre: "),
        "apellido": input("Ingrese apellido: ")
    }
    response = requests.post(url, json=usuario)
    if response.status_code == 200 or response.status_code == 201:
        print("Usuario creado exitosamente.")
    else:
        print(f"Error al crear usuario: {response.status_code}")


#######################################################
######  Procesamiento principal
#######################################################
print("Iniciando " + datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S"))
cargar_variables()

print("Opciones disponibles:")
print("1. Listar usuarios")
print("2. Listar monedas")
print("3. Listar clientes")
print("4. Detalle de usuario")
print("5. Detalle de cliente")
print("6. Detalle de moneda")
print("7. Crear cliente")
print("8. Editar usuario")
print("9. Eliminar moneda")
print("10. Crear moneda")
print("11. Crear usuario")
print("0. Salir")

while True:
    opcion = int(input("Seleccione una opción: "))
    if opcion == 1:
        listar_usuarios()
    elif opcion == 2:
        listar_monedas()
    elif opcion == 3:
        listar_clientes()
    elif opcion == 4:
        id_usuario = input("Ingrese ID del usuario: ")
        detalle_usuario(id_usuario)
    elif opcion == 5:
        ci_cliente = input("Ingrese CI del cliente: ")
        detalle_cliente(ci_cliente)
    elif opcion == 6:
        codigo_iso = input("Ingrese código ISO de la moneda: ")
        detalle_moneda(codigo_iso)
    elif opcion == 7:
        crear_cliente()
    elif opcion == 8:
        editar_usuario()
    elif opcion == 9:
        eliminar_moneda()
    elif opcion == 10:
        crear_moneda()
    elif opcion == 11:
        crear_usuario()
    elif opcion == 0:
        print("Finalizando conexión...")
        break
    else:
        print("Opción no válida.")

print("Finalizando " + datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S"))