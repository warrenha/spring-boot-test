#!/usr/bin/env bash

set -euo pipefail

project_root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
image_name="${IMAGE_NAME:-spring-boot-test}"
image_tag="${1:-latest}"
jar_path="$project_root/target/spring-boot-test-0.0.1-SNAPSHOT.jar"

if ! command -v docker >/dev/null 2>&1; then
    echo "Docker is not installed or is not available on PATH." >&2
    exit 1
fi

if [[ ! -f "$jar_path" ]]; then
    echo "Application JAR not found. Run './scripts/buildJar.sh' first." >&2
    exit 1
fi

exec docker build \
    --file "$project_root/docker/Dockerfile" \
    --tag "${image_name}:${image_tag}" \
    "$project_root"
