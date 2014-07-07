using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace java.util.ArrayList
{
    public class ArrayList<E> : System.Collections.ArrayList
    {
        public int size();
        public void add(E e);
        public E get(int index);
    }
}
