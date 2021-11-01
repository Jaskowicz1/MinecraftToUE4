# MinecraftToUE4
 Bring Minecraft Schematics to UE4
 
## Showcase
 [Video with no Mic](https://youtu.be/gExHFI1gZjo)

## How does this work?
 In minecraft, I preform a similar action to worledit, taking a big grid of blocks. Then I preform a command to save all the blocks (excluding air blocks) to a text file. Then in Unreal Engine I load this text file every second and spawn blocks based on the minecraft location. The blocks are relative to Position 1.
 
 These text files are set out in `<Block_Name>,<x>,<y><z>`. Unreal then splits this by "," and proceeds to pipe the data into the spawning actor.
 
## What use does this have?
 Little to none. This isn't meant to be a project to improve blocking out. There are already tools in Unreal Engine for that. This is simply just a project that I had an idea for randomly and I wanted to see how possible it was.
 
## Can I use this?
  Sure! There are some project files above if you want to import them, However, I really do not recommend using this if you're not planning to just mess around with it.
  
  Drag everything but "MinecraftPlugin" and all that folder's content to the unreal project folder you'll be using.
  
## Example of Text File
 ```
 wood,0,0,0
 wood,1,1,0
 wood,2,2,0
 wood,3,3,0
 wood,4,4,0
 ```
 
## Isn't using Spawn Actor multiple times bad?
 Yes. It is. But with this instance, all the blocks have shadows disabled and tick disabled. This will improve performance quite a bit. Again, this project isn't meant for blocking out levels, nor is it meant for production use. This project is simply just for fun.
