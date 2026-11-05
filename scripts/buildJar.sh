#!/usr/bin/env bash

set -euo pipefail

project_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$project_root"

if [[ ! -x ./mvnw ]]; then
    echo "Maven Wrapper not found or is not executable." >&2
    exit 1
fi

exec ./mvnw --batch-mode clean package
