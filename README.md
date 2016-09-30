# examprep_jpa_rest_api

General part:

	Elaborate on some of the characteristics of REST, like: Stateless, Cachable, Layered System, Uniform Interface etc:
		*Uniform Interface
			As the term suggests it is an interface that is uniform, meaning it only appears in one form every time. 
			It directly relates to the principle of CRUD in terms of database: CREATE, READ, UPDATE, DELETE, which is an 'protocol/interface'	
			for how we manipulate a database. Since REST is tied to HTTP it becomes uniform because it corresponds to the requests we know:
			GET, POST, PUT, DELETE. Consider it a contract for communication between clients and server (a protocol). We have the components:
			Identify the resource : URI
			Resource representation : JSON etc.
			Metadata : headers in response, requests etc.
			Hypermedia : The available methods from a URI 
		*Layered System
			The system you have is only as layered as you choose to. The idea is to seperate code into layers such as mappers, facades, entities etc. 
			These layers should be easily edited and have a configuration such as to it is easy to add / remove layers as needed going forward.
			It's important that the client never directly calls the application server, but communicates through a intermediary (UI etc).
		*Stateless
			When we are working with HTTP we are working stateless. That is the client must send all necessary information with every request to a
			webservice. This is what is called "stateless". We do not save any information about the client who contacted us previously and must receieve
			everything over new. We can make hacked-solutions to simulate state, but HTTP in its nature is stateless. 
			PRO : Imagine a huge system where the server kept state regarding all clients and there was millions of them. We would overload. 
			CON : We save nothing.
		*Cachable
			Cachable is a term that refers to the ability of caching popular requests. There is no need to commit ressources to generating the same response	
			from scratch - over and over - when we can just cache a response, ready to be sent when we receive a similar request the next time.
			It varies from resource to resource what is cached and it is decided by client activity. Many requests of pattern A, let's cache our response
			so we can send it the next time we receive a pattern A request.
			
	Elaborate on how JSON or XML supports communication between subsystems, even when the subsystems are implemented on different platforms:
		*JSON and XML is basically just formated plain-text. It is not platform specific and therefore any system that receives this format can work with it.
		The strength is that the implementation on the server side is irrelevant when what is being communicated from client-server is JSON/XML. 
		The webservice can have been made in Java, C#, C++, Python and so on and still function as long as we use JSON or XML when parsing data from
		client-server. 