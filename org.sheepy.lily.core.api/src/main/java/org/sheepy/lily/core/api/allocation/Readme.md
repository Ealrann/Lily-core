Allocation allows to instantiate some objects in a specific order, with dependencies and children.
The children are allocated **after** the parent.

One allocation at a time is considered as the **main allocation**, and can be retrieve as a normal adapter with `myObject.adapt(MyAllocation.class)`.

[**Wip** - working on trees] ~~Due to the main allocation system, We cannot allocate mutliple differents allocation trees. On allocation at a time shoud be the active one. 
However, it's still possible to keep multiple allocation as dirty, pick one and update it when it's unlocked (not in use).~~