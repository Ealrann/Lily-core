# Lily-core

Lily-core is the shared foundation for the Lily ecosystem.
It is the part that defines the common language used by engines,
tools, and games to describe and run an application model.

At its heart, Lily-core provides a set of core concepts:
applications, engines, cadence (timing), resources, UI,
variables, actions, and inference structures.
Those concepts are exposed as typed Java APIs and model packages,
so higher-level modules can extend them without rewriting basics.

Lily-core also owns the runtime orchestration layer.
It handles application launch and stop operations,
drives the main loop, coordinates input polling,
executes model commands, and manages lifecycle transitions.

A second major role is extension composition.
Lily-core discovers model extensions and adapters at runtime,
then assembles them into a coherent registry and execution graph.
This is what allows backends like Lily-vulkan to plug in cleanly.

Lily-core depends on LMF (Light Model Framework):
https://github.com/Ealrann/lmf
Together, they provide the model-driven base for projects like VSand.
