## Generating JavaScript Protobuf Files

This guide outlines the steps involved in generating JavaScript Protobuf files from `.proto` files.

### Installing protoc-gen-js

To generate JavaScript Protobuf files, you'll need to install the `protoc-gen-js` plugin:

```bash
npm install -g protoc-gen-js
```

### Addressing Security Vulnerabilities

If you encounter any security vulnerabilities during the installation, you can address them using `npm audit fix --force`:

```bash
npm audit fix --force
```

## Prerequisites

Before proceeding with the generation process, ensure you have the Protocol Buffers (Protobuf) compiler installed. If not, download it from the official [GitHub repository](https://github.com/protocolbuffers/protobuf/releases).

### Installation Steps

1. Download the ZIP file corresponding to your platform (e.g., `protoc-3.17.3-win64.zip`).

2. Extract the downloaded ZIP file to a location on your computer.

3. **Adding to PATH (Optional but recommended):** To use the `protoc` command without specifying the full path, add the `bin` folder containing `protoc.exe` to your system's PATH environment variable. This allows you to run `protoc` from any directory in your command prompt.

### Running `protoc`

Once you've installed the Protobuf compiler, you can use it to compile your `.proto` files. If you've added `protoc` to your PATH, you can simply run:

```bash
protoc --js_out=import_style=commonjs,binary:. ./employees.proto
```
(here employees.proto is my proto file name)<br>
This command will generate a JavaScript file in the same directory as the `employees.proto` file. file name will be like employees_pb.js

### Installing the google-protobuf Package

To work with the generated Protobuf JavaScript code, you'll need to install the `google-protobuf` package. This package provides the necessary runtime support for your generated Protobuf code.

You can install it using a package manager like npm:

```bash
npm install google-protobuf
```

With the `google-protobuf` package installed, you can use the generated JavaScript Protobuf code in your project.
