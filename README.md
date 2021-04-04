### BinServlet
**BinServlet** - is an abstraction layer used for unifying processing pipeline.
The [BinServletDiagram.puml](https://github.com/alexkolundev/java-bin-servlet/blob/master/bin-servlet/BinServletDiagram.puml) 
diagram can be viewed with the PlantUML plugin installed.
**BinServlet** is a simplified model of the **spring-web** (?) (FrameworkServlet, DispatcherServlet, HandlerExecutionChain, HandlerExceptionResolver)

### Cases:
1. Formalization of the request handling pipeline for a binary protocols
2. Common actions before a custom processing
3. Mapping a request into a method for custom processing
4. Common actions after custom processing
5. Uniform of exception handling