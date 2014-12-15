package genieprojet.aspects;

public aspect Logging {
	pointcut methodCall(): execution(* *.*(..));
	pointcut classToNotLog() : within(FileLogger);
	pointcut desiredMethodLog() : methodCall() && !classToNotLog(); 
	
	after(): desiredMethodLog() {
		FileLogger.printToLogFile("Appel de la methode: " + thisJoinPoint.getSignature() + "\n");

	    Object[] arguments = thisJoinPoint.getArgs();
	    for (int i =0; i < arguments.length; i++){
	        Object argument = arguments[i];
	        if (argument != null){
	        	FileLogger.printToLogFile("Argument de type: " + argument.getClass().toString() + " // Valeur: " + argument + "\n");
	        }
	    }

	    FileLogger.printToLogFile("Fin de la methode: " + thisJoinPoint.getSignature() + "\n");
	}
}
