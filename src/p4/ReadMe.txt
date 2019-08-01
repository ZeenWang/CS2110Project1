This is a heap class. Its methods are listed down below:

Override methods:

Heap(Comparator<? super P> com)

Comparator<? super P> comparator()

void     size()

E        poll()

E        peek()

void     add(Object, Object)

void     changePriority(Object, Object)


Additional methods:

void     merge(Heap<E,P>)

void     changeElement(P p,E e)

String   toString()

void     removeElement(E e)