#!/usr/bin/env bash

set -euo pipefail

project_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
jar_path="$project_root/target/spring-boot-test-0.0.1-SNAPSHOT.jar"

if [[ ! -f "$jar_path" ]]; then
    echo "Application JAR not found. Run './scripts/buildJar.sh' first." >&2
    exit 1
fi

exec java -jar "$jar_path" "$@"
