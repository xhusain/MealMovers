# Jenkins Build and Deployment

This project was built and deployed using Jenkins.

## Jenkins job

- Job type: Freestyle project
- Source control: Git
- Branch: `meal_movers`
- Build trigger: SCM polling
- Build command: `mvn clean package`

## Build output

The Maven project uses WAR packaging. A successful build produces:

```text
target/mealmovers.war
```

Maven runs the project's tests as part of the package lifecycle before creating
the WAR file.

## Deployment

The generated WAR file was deployed to Apache Tomcat using the Jenkins Deploy
plugin. The deployment targeted a local Tomcat 9 server.

The deployment flow was:

1. Jenkins checked out the project source.
2. Maven cleaned previous build output and packaged the application.
3. Jenkins located the generated WAR file.
4. Jenkins deployed the WAR file to Tomcat.

Credentials and machine-specific Jenkins settings are intentionally not stored
in this repository.
