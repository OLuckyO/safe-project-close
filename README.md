# Safe Project Close

Safe Project Close prevents accidental project-window closure in JetBrains IDEs.

It is especially useful with PyCharm Remote Development and JetBrains Gateway, where several project windows can be
connected to the same remote backend.

## Features

- Confirms before closing a project when another project remains open.
- Shows the name of the project being closed.
- Cancels the close operation when you choose **Cancel**.
- Leaves the IDE's built-in behavior unchanged for the last open project.
- Supports English and Simplified Chinese.
- Works with Remote Development and Split Mode.

## Installation

Open **Settings | Plugins | Marketplace**, search for **Safe Project Close**, and select **Install**.

To install a local build, open **Settings | Plugins**, choose **Install Plugin from Disk**, and select the plugin ZIP.

## Compatibility

- IntelliJ Platform 2026.1 or later
- PyCharm and other IntelliJ Platform-based IDEs
- JetBrains Client / Remote Development

## Build

```shell
./gradlew buildPlugin
```

On Windows, use `gradlew.bat buildPlugin`.

## License

Licensed under the [Apache License 2.0](LICENSE).
