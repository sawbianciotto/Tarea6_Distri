#!/usr/bin/env bash
set -euo pipefail

# Crea/usa un virtualenv local en cliente-python/venv e instala dependencias
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

if [ ! -d "venv" ]; then
  python3 -m venv venv
fi

# Activar e instalar
. venv/bin/activate
pip install --upgrade pip
pip install -r requirements.txt

echo "Entorno creado. Activa con: source venv/bin/activate"
