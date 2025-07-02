```bash
# launch.json in .vscode
"env": {
    "TELEGRAM_BOT_TOKEN": "$YOU_TOKEN_HERE"
}

# .env in devcontainer
echo 'TELEGRAM_BOT_TOKEN=$YOU_TOKEN_HERE' > .devcontainer/.env

# Fish
set -x TELEGRAM_BOT_TOKEN $YOU_TOKEN_HERE
```