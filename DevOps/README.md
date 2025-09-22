# Docker Application Setup Guide

This guide will help you run a full-stack application with React frontend, backend API, and PostgreSQL database using Docker Compose on any operating system.

## 🏗️ Application Architecture

- **Frontend**: React application running on port 3000
- **Backend**: API server running on port 5000
- **Database**: PostgreSQL database
- **Containerization**: Docker & Docker Compose

## 📋 Prerequisites by Operating System

### Windows 10/11

1. **Docker Desktop for Windows**
   - Download from [Docker Hub](https://hub.docker.com/editions/community/docker-ce-desktop-windows)
   - Minimum requirements:
     - Windows 10 64-bit: Pro, Enterprise, or Education (Build 16299 or later)
     - WSL 2 feature enabled
     - Virtualization enabled in BIOS
   - **Important**: Docker Desktop must be running before executing commands

2. **PowerShell or Command Prompt**
   - Windows PowerShell (recommended) or Command Prompt
   - Run as Administrator if needed

### macOS

1. **Docker Desktop for Mac**
   - Download from [Docker Hub](https://hub.docker.com/editions/community/docker-ce-desktop-mac)
   - Minimum requirements:
     - macOS 10.15 or newer
     - 4 GB RAM minimum
   - **Important**: Docker Desktop must be running before executing commands

2. **Terminal Application**
   - Built-in Terminal app or alternatives like iTerm2

### Linux (Ubuntu/Debian/CentOS/RHEL)

1. **Docker Engine**
   ```bash
   # Ubuntu/Debian
   sudo apt update
   sudo apt install docker.io docker-compose
   
   # CentOS/RHEL/Fedora
   sudo yum install docker docker-compose
   # or for newer versions
   sudo dnf install docker docker-compose
   ```

2. **Docker Compose**
   ```bash
   # If not installed with Docker
   sudo curl -L "https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
   sudo chmod +x /usr/local/bin/docker-compose
   ```

3. **User Permissions**
   ```bash
   # Add your user to docker group to avoid using sudo
   sudo usermod -aG docker $USER
   # Log out and back in for changes to take effect
   ```

4. **Start Docker Service**
   ```bash
   # Ubuntu/Debian
   sudo systemctl start docker
   sudo systemctl enable docker
   
   # CentOS/RHEL
   sudo systemctl start docker
   sudo systemctl enable docker
   ```

## 🚀 Quick Start Guide

### Step 1: Prepare Your Environment

1. **Create a project directory** (optional but recommended):
   ```bash
   # Windows PowerShell
   mkdir docker-app
   cd docker-app
   
   # Linux/macOS
   mkdir docker-app && cd docker-app
   ```

2. **Copy the docker-compose.yml file** to your project directory
   - Download or copy the `docker-compose.yml` file to your chosen directory
   - Ensure the file is named exactly `docker-compose.yml`

### Step 2: Verify Prerequisites

**Windows:**
- ✅ Ensure Docker Desktop is **running** (check system tray icon)
- ✅ Open PowerShell or Command Prompt

**macOS:**
- ✅ Ensure Docker Desktop is **running** (check menu bar icon)
- ✅ Open Terminal

**Linux:**
- ✅ Verify Docker service is running:
  ```bash
  sudo systemctl status docker
  ```
- ✅ Test Docker without sudo (if user added to docker group):
  ```bash
  docker --version
  ```

### Step 3: Run the Application

1. **Navigate to the directory** containing your `docker-compose.yml` file

2. **Build and start all services**:
   ```bash
   docker-compose up --build
   ```

   > **Note**: The `--build` flag ensures images are rebuilt if there are any changes.

3. **Wait for all services to start**. You should see output indicating:
   - Database is ready to accept connections
   - Backend API is running
   - Frontend is compiled and served

### Step 4: Access the Application

Once all containers are running successfully:

- **Frontend (React App)**: [http://localhost:3000](http://localhost:3000)
- **Backend API**: [http://localhost:5000/api/items](http://localhost:5000/api/items)
- **Database**: PostgreSQL running internally on port 5432 (not exposed externally)

## 🛠️ Additional Commands

### Run in Background (Detached Mode)
```bash
docker-compose up -d --build
```

### View Running Containers
```bash
docker-compose ps
```

### View Logs
```bash
# All services
docker-compose logs

# Specific service
docker-compose logs frontend
docker-compose logs backend
docker-compose logs db
```

### Stop the Application
```bash
# Stop and remove containers
docker-compose down

# Stop, remove containers, and remove volumes (⚠️ deletes database data)
docker-compose down -v
```

### Restart Services
```bash
docker-compose restart
```

## 🔧 Troubleshooting

### Common Issues

**"Docker daemon not running" error:**
- **Windows/macOS**: Start Docker Desktop application
- **Linux**: `sudo systemctl start docker`

**Port already in use:**
- Check if ports 3000 or 5000 are being used by other applications
- Stop conflicting services or modify ports in docker-compose.yml

**Permission denied (Linux):**
- Run with sudo: `sudo docker-compose up --build`
- Or add user to docker group (see Prerequisites)

**Containers fail to start:**
- Check logs: `docker-compose logs [service-name]`
- Ensure adequate disk space and memory
- Try rebuilding: `docker-compose build --no-cache`

### System Requirements

- **RAM**: Minimum 4GB (8GB recommended)
- **Disk Space**: At least 2GB free space
- **Network**: Internet connection for initial image download

## 📝 Notes

- First run will take longer as Docker images need to be downloaded
- Database data persists between runs (stored in Docker volume)
- To reset database, use: `docker-compose down -v`
- The application uses pre-built images from Docker Hub

## 🆘 Getting Help

If you encounter issues:

1. Check the troubleshooting section above
2. Verify all prerequisites are met
3. Check container logs for specific error messages
4. Ensure Docker Desktop/Engine is running and up to date

## Issues and Contributions

Are you facing issues or have suggestions for improvements? Feel free to open an issue or submit a pull request on the project's GitHub repository.
The Project Github Repository: [Yuvraj960/DevOps/Docker/Project 1](https://github.com/Yuvraj960/DevOps/tree/main/Docker/Project%201)