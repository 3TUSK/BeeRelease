/**
 * Copyright 2017 3TUSK, et al.
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package info.tritusk.beerelease;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.item.ItemTossEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod(modid = "beerelease", name = "Bee Release", version = "1.0.0", useMetadata = true)
public enum BeeRelease {

    INSTANCE;

    @Mod.InstanceFactory
    public BeeRelease getInstance() {
        return INSTANCE;
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(INSTANCE);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onItemToss(ItemTossEvent event) {
        if (event.getEntityItem().getEntityItem().getItem().getClass().getName().equals(BEE)) {
            event.setCanceled(true);
        }
    }

    private static final String BEE = "forestry.apiculture.items.ItemBeeGE"; // It is the same since ForestryMC 3.1
}
