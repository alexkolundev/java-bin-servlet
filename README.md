### BinServlet
** BinServlet ** - is an abstraction for unifying the processing pipeline.
The [BinServletDiagram.puml](https://github.com/alexkolundev/java-bin-servlet/blob/master/bin-servlet/BinServletDiagram.puml) 
diagram can be viewed with the PlantUML plugin installed.
** BinServlet ** is a simplified model ** spring-web ** (FrameworkServlet, DispatcherServlet, HandlerExecutionChain, HandlerExceptionResolver)

### Cases:
1) Unification of the request processing pipeline for different proprietary protocols and this not HTTP
2) Common actions before custom processing
3) Mapping the request into a method for custom processing
4) Common actions after custom processing
5) Unification of exception handling