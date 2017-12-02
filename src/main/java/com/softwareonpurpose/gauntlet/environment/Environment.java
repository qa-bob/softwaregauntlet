/*Copyright 2017 Craig A. Stockton

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.*/
package com.softwareonpurpose.gauntlet.environment;

public class Environment {

    private static EnvironmentDefinition environment;

    private Environment() {
    }

    public static EnvironmentDefinition getInstance() {
        if (environment == null) {
            String env = System.getProperty("env");
            switch (env) {
                case DevIntegrationEnvironment.NAME:
                    environment = DevIntegrationEnvironment.getInstance();
                    break;
                case AutomatedAcceptanceEnvironment.NAME:
                    environment = AutomatedAcceptanceEnvironment.getInstance();
                    break;
                case CapacityEnvironment.NAME:
                    environment = CapacityEnvironment.getInstance();
                    break;
                case ManualAcceptanceEnvironment.NAME:
                    environment = ManualAcceptanceEnvironment.getInstance();
                    break;
                case BetaAcceptanceEnvironment.NAME:
                    environment = BetaAcceptanceEnvironment.getInstance();
                    break;
                default:
                    environment = ProductionEnvironment.getInstance();
            }
        }
        return environment;
    }
}
