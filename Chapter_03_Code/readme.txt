When deploying to GlassFish 4.1 (included with NetBeans 8.0.1 and newer) some of the projects on this chapter may fail to compile.

If NetBeans complains about not recognizing some of the CDI specific annotations, you will have to include cdi-api.jar in your project by right-clicking on Libraries, selecting Add JAR/Folder... and selecting cdi-api.jar from the modules folder of your glassfish installation.

ICEfaces does not support JSF 2.2, which is the version included with GlassFish 4.1. In order to run the ICEfaces sample project, please downgrade to GlassFish 4.0.

ICEfaces and RichFaces libraries will need to be created as explained in the chapter before the ICEfaces and RichFaces sample projects can be executed.
