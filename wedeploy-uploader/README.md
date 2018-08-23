##  Command Line Parameters
> * buildNumber : The number of failure build for a checker.
> * checkerName : The failure checker name.
> * checkerType : The type of checker ; if the checker is integration checker, so type of that is "integration"; otherwise it's "single". Only support two type at present. 
> * delete : Deleted checker that won't use.
##  Usage
### 1. Need type three parameters at command line when operation wedeploy-uploader jar(`buildNumber`, `checkerName`, `checkerType`). For example:
> * java -jar wedeploy-uploader.jar `buildNumber` 103 `checkerName` Functional-Tests-Checker `checkerType` integration
### 2. If need delete a checker, please type parameter `delete`. For example:
> * java -jar wedeploy-uploader.jar `delete` Funtional-Tests-Checker
### 3. src/main/resource/config.properties
The property `server.ip` is jenkin's host address.
The property `log.home.path` is the path of storage logs at local.
