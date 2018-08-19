# A simple example about exceptions in transactions in Spring

This repository is a simple demo testing the way how transactions behave in Spring. I created it to test my assumptions about it. When an exception is thrown during transaction, and Spring knows about it, the transaction *cannot* be commited. However in order for Spring to know about it, this exception has to be unhandled by our code. If we catch the exception ourselves, the transaction can happily proceed. But if we call another transactional method form within our transaction and the inner method does not catch it's exception, then the transaction is already marked for good and cannot be commited. This is of course true only if we are reusing the same transaction for the other transactional method.

You can check the behaviour by acessing these two endpoints:

## Endpoint /book
The method BookService.getBooks() throws and catches an exception,
Spring does not know about it, so the transaction succeeds.


## Endpoint /ex
The method BookService.getBooksUnsafe() throws an exception and is 
called from BookRequestDispatcher.getBooks(), which is also transctional. 
It will fail, because the transaction will be marked as rollback only. 
On the other hand, if you specify Propagation.REQUIRES_NEW on getBooksUnsafe(), 
it will work again, because the original transaction is suspended 
and a new one is used.  
