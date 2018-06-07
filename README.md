# A simple example about exceptions in transactions in Spring

#### Endpoint /book
The method BookService.getBooks() throws and catches an exception,
Spring does not know about it, so the transaction succeeds


#### Endpoint /ex
The method BookService.getBooksUnsafe() throws an exception and is 
called from BookRequestDispatcher.getBooks(), which is also transctional. 
It will fail, because the transaction will be marked as rollback only. 
On the other hand, if you specify Propagation.REQUIRES_NEW on getBooksUnsafe(), 
it will work again, because the original transaction is suspended 
and a new one is used.  